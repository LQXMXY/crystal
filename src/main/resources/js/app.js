import Hello from "./Hello";
import React from 'react';
import ReactDOM from 'react-dom';

/*const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');*/

/*import React from 'react';
import ReactDOM from 'react-dom';*/

/*class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {employees: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/'}).done(response => {
            this.setState({employees: response.entity._embedded.employees});
        });
    }

    render() {
        return (
            <EmployeeList employees={this.state.employees}/>
        )
    }
}

class EmployeeList extends React.Component{
    render() {
        const employees = this.props.employees.map(employee =>
            <Employee key={employee._links.self.href} employee={employee}/>
        );
        return (
            <table>
                <tbody>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Description</th>
                </tr>
                {employees}
                </tbody>
            </table>
        )
    }
}*/

ReactDOM.render(
    <Hello />,
    document.getElementById('react')
)