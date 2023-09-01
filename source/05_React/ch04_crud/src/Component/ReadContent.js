import { Component } from "react";
import './ReadContent.css';

class ReadContent extends Component{
    render(){
        console.log ('ReadContent Rendering');
        return(
            <article>
                <h2> {this.props.title} </h2>
                     {this.props.desc}
            </article>
        );
    }
}
export default ReadContent;