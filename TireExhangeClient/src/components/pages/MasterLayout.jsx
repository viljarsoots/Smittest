import React, { Component } from 'react';

import SideNavBar from '../containers/SideNavBar.jsx';
import TopNavBar from '../containers/TopNavBar.jsx';
import MainTable from '../containers/MainTable.jsx';
import {Route, Switch } from 'react-router-dom';
import MainPage from '../containers/MainPage.jsx';




export default class MasterLayout extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <div className="page-wrapper">

                <SideNavBar />
                
                <div className="page-container">

                    <TopNavBar />

                    <div className="main-content">
                        <div className="section__content section__content--p30">


                            <Switch>
                                <Route exact path="/" component={MainPage} />
                                <Route path="/machineTable/:from" component={MainTable} />
                                <Route path="/mainPage/" component={MainPage} />

                                
                            </Switch>

                        </div>
                    </div>

                </div>

            </div>


        );
    }

}