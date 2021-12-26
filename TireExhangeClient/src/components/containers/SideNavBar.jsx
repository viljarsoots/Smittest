import React from 'react';
import './SideNavBar.css';


export default class SideNavBar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
                        active: false, 
                        class: 'has-sub'
                    }

        this.handleClick = this.handleClick.bind(this);
  
    }



    handleClick (e) {

        const currentState = this.state.active; //false

        if(!currentState) {
            
            e.target = 'has-sub active'
            this.setState({class: e.target});
            this.setState({active: true});

        }   else {
            this.setState({class: 'has-sub'});
            this.setState({active: false});
        }     

    }

    render() {
        return (
            
            <aside className="menu-sidebar d-none d-lg-block">
                <div className="logo">
                    <a href="/" title= "Tire Change Booking">
                        <img src="/assets/images/icon/3Tires234x100.jpg" alt="Tires" />
                    </a>
                </div>
                <div className="menu-sidebar__content js-scrollbar1 ps">
               <br/>
                <img src="/assets/images/icon/Tiers.jpg" alt="Tires" />
                <br/>
                <br/>
                <img src="/assets/images/icon/images.jpg" alt="Tires" />


                    <div className="ps__rail-x" style={{ left: "0px", bottom: "0px" }}>
                        <div className="ps__thumb-x" tabIndex="0" style={{ left: "0px", width: "0px"}}>
                </div>
                </div>
                    <div className="ps__rail-y" style={{top: "0px", right: "0px"}}>
                        <div className="ps__thumb-y" tabIndex="0" style={{top: "0px", height: "0px"}}>
                        </div>
                    </div>
                </div>
            </aside>
           
           
        );
    }

}
