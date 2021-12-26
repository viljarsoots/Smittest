import React from 'react';
import BootstrapTable from 'react-bootstrap-table-next';
import 'react-bootstrap-table-next/dist/react-bootstrap-table2.min.css';
import ToolkitProvider, { Search } from 'react-bootstrap-table2-toolkit';
import 'react-bootstrap-table2-toolkit/dist/react-bootstrap-table2-toolkit.min.css';
import paginationFactory, { PaginationProvider, PaginationListStandalone, SizePerPageDropdownStandalone } from 'react-bootstrap-table2-paginator';
import './MainTable.css';
import  {mockDataUrl,axios,echoPostUrl} from '../data/config.js';


const { SearchBar } = Search;


const customTotal = (from, to, size) => (
	<span className="react-bootstrap-table-pagination">
		Showing {from} to {to} of {size} Results
  </span>
);

export default class MainTable extends React.Component {

	constructor(props) {
		super(props);
			this.state = {
				timeData: [],
				contactInformation: ''
			};

		this.formatProductDetailsButtonCell=this.formatProductDetailsButtonCell.bind(this);
        this.productDetails=this.productDetails.bind(this);
		this.componentDidMount = this.componentDidMount.bind(this);
		this.handelGet = this.handelGet.bind(this);
		
	}
	

	productDetails = (e) => {

		let { id} = e.target;
		console.log("See Details for Id: " + id);
		
		const options = {
            headers: { "Content-Type": "application/json", "Accept": "application/json" },    
        };
        let data = {
            contactInformation: this.state.location
                    };
        axios.put(echoPostUrl+"book/"+id, data, options)
            .then((response) => {
                console.log("response from echo server");   
            }).catch((exception) => {
                console.log(exception);
            })
		this.handelGet();
	}
	
	formatProductDetailsButtonCell = (cell, row) => {
		let clickHandler = this.productDetails;
		let aBtn = React.createElement('button',{ id:row.id, className: "btn btn-success btn-lg btn-block", onClick: clickHandler }, 'Book Time');
		return aBtn;
	}

	componentDidMount(){    
		this.handelGet();
	   }

	   handelGet(event) {
		   let from = this.props.match.params.from;
		let dateToSend = (from.length > 11)? from.replace("&", "/") : from;
		console.log(dateToSend);
        axios.get(mockDataUrl+dateToSend)
            .then((response) => {

				this.setState({timeData: response.data});
				 console.log(response.data);


			}).catch((exception) => {
                console.log(exception);
            });
    }

	render() {

		const paginationConfig = {
			custom: true,
			paginationSize: 3,
			pageStartIndex: 1,
			firstPageText: 'First',
			prePageText: 'Back',
			nextPageText: 'Next',
			lastPageText: 'Last',
			nextPageTitle: 'First page',
			prePageTitle: 'Pre page',
			firstPageTitle: 'Next page',
			lastPageTitle: 'Last page',
			showTotal: true,
			paginationTotalRenderer: customTotal,
			sizePerPageList: [{
				text: '10', value: 10
			}, {
				text: '25', value: 25
			}, {
				text: '50', value: 50
			}, {
				text: '100', value: 100
			}, {
				text: 'All', value: this.state.timeData.length
			}] // A numeric array is also available. the purpose of above example is custom the text
		};

		const columns = [{
			dataField: 'id',
			text: 'ID',
			hidden: true
				
		}, {
			dataField: 'time',
			text: 'Time',
		
		}, {
			dataField: 'location',
			text: 'Location'
		
		},{
			dataField: 'carType',
			text: 'CarType'
		},{
			dataField: 'action',
			text: '',
			formatter: this.formatProductDetailsButtonCell
		}];

		const contentTable = ({ paginationProps, paginationTableProps }) => {

			return (
				<div className="container">

					<ToolkitProvider
						keyField="id"
						columns={columns}
						data={this.state.timeData}
						search
					>
						{
							(toolKitProps) => {

								return (
									<div>
										<div className="row">
											<div className="col-sm-8">
											</div>
											<div className="col-sm-4">
												<SearchBar {...toolKitProps.searchProps} />
											</div>
										</div>
										<br />
										<BootstrapTable
											striped
											hover
											{...toolKitProps.baseProps}
											{...paginationTableProps}
											
										/>

									</div>);


							}
						}
					</ToolkitProvider>
					<div className="row" id="pagination">
						<div className="col-sm">
							<div className="row justify-content-start">
								<SizePerPageDropdownStandalone {...paginationProps} />
							</div>
						</div>
						<div className="col-sm">
							<div className="row justify-content-end">
								<PaginationListStandalone {...paginationProps} />
							</div>
						</div>
					</div>
				</div>
			);
		}


		return (
			<div id="machineTable">
				<h2>Available Tire Change Times</h2>

				<PaginationProvider pagination={paginationFactory(paginationConfig)} >
					{contentTable}
				</PaginationProvider>

			</div>
		);


	}


}