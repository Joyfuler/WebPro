import React, { Component } from "react";
import './Subject.css';

class Subject extends Component{
    render(){
        console.log('Subject Rendering');
        return(
            <header>
                <h1><a href="/"
                onClick ={e => {
                    e.preventDefault();
                    this.props.onChangePage(e);
                }}>{this.props.title}</a></h1>
                {this.props.sub}
                <hr/>
            </header>
        );
    }
}
export default Subject;