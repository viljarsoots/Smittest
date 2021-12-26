import React from 'react';

import './TopNavBar.css';

export default class TopNavBar extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return(
           
            <header className="header-desktop">
            <div className="section__content section__content--p30">
                <div className="container-fluid">
                     <div className="header-wrap">
                         <h1>Tire Change Booking</h1>
                       
                    </div> 
                </div>
            </div>
        </header>
        );
    }
    
    
    
    



}