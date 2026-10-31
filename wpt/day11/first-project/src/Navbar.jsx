import { Component } from "react";
export class Navbar extends Component {
  render() {
    //override as present in compnnent used to provide something the html code in this render func so react calls this to display ui
    return (
      <div>
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Contact Us</a>
      </div>
    );
  }
}
