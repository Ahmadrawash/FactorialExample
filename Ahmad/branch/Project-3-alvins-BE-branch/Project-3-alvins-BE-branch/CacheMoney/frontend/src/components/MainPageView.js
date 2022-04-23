import React, { useState } from "react";
import AccountObject from "./AccountObject.js";
//import AccountsView from "./Account/AccountsView";
import Navigation from "./NavBar";

function MainPageView(props) {
	//let accountPreview = [];
	//   let [accountPreview, setAccountPreview] = useState([]);
	let [accountPreview, setAccountPreview] = useState([
		"Checking",
		"Savings",
		"California Move Stash",
		"Wu-tang",
	]);

	// this will render a bunch of account objects
	// for (let i = 0; i < 5; i++) {
	// 	accountPreview.push(<AccountObject key={"account" + i} />);
	// }

	// This displays a list of account names
	let showAccountPreview = accountPreview.map((account) => {
		return <li key="main-page-account-info" className="list-accounts">{account}</li>;
	});
	

	return (
		<div id="main-page-container">
			<div className="headerContainer">
				<Navigation />
				<h1> Accounts </h1>
				<hr />

				<h2> CACHE FINANCE</h2>

				{showAccountPreview}
				{/* {accountPreview} */}

				<h2> CACHE RECREATION</h2>
				{/* <AccountObject /> */}
				<hr />
			</div>
		</div>
	);
}

export default MainPageView;
