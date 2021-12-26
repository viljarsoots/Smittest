import React from 'react';





export default class MainPage extends React.Component {


    constructor(props) {
        super(props);
        this.state = {
            dateFrom:'',
            dateTo: ''
            
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    
    }

    handleChange(event) {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    }

    

    handleSubmit(event) {

        let from = (this.state.location === "Manchester")? 
        this.state.dateFrom : (this.state.dateFrom + "&" + this.state.dateTo); 
            console.log(from);
        
             this.props.history.push("/machineTable/"+ from);
        //}

    }

    

    

    render() {
        return (

            <div className="page-content--bge5">
                <div className="container">
                    <div className="wrap">
                        <div className="login-content">
                            <div className="login-logo">
                                
                                    <img src="/assets/images/icon/WorkshopX200.jpg" alt="TireWorkshop" />
                                
                                <h2 justify="center">Book time for tire exchange</h2>
                            </div>
                            <div className="login-form">
                                <form action="" onSubmit={this.handleSubmit}>
                                <div className="form-group">
                                        <label>Car type</label>
                                        <select className="au-input au-input--full" type="select"
                                            value={this.state.carType} onChange={this.handleChange} name="carType" placeholder="CarType" >
                                        <option value="0"></option>
                                        <option value="Passenger car">Passenger Car</option>
                                        <option value="Truck">Truck</option>
                                        </select>
                                    </div>


                                <div className="form-group">
                                        <label>Location</label>
                                        <select className="au-input au-input--full" type="select" required
                                            value={this.state.option} onChange={this.handleChange} name="location" placeholder="Location" >
                                        <option></option>
                                        <option disabled = {this.state.carType === "Truck"} >London</option>
                                        <option >Manchester</option>
                                        </select>
                                    </div>
                                    
                                    <div className="form-group">
                                        <label>Choose date from</label>
                                        <input className="au-input au-input--full" type="date" required
                                            value={this.state.dateFrom} onChange={this.handleChange} name="dateFrom" placeholder="Date from" />
                                    </div>
                                    <div className="form-group">
                                        <label>Date to</label>
                                        <input className="au-input au-input--full" type="date" disabled = {this.state.location === "Manchester"} required
                                            value={this.state.dateTo} onChange={this.handleChange} name="dateTo" placeholder="Date to" />
                                    </div>
                                    <button className="btn btn-warning btn-lg btn-block" onClick={this.onSubmit} >Find Free Times</button>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>

        );


    }



}