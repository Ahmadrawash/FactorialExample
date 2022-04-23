import Title from "./Title.js";

// The splash screen is the first view the user will see when using the app.
// It prompts the user to login or register.
function SplashView() {
	return (
		<div id="splash-outer-container">
			Outer container test
			<div id="splash-container">
				<Title />
				<div id="splash-right">
					<span id="welcome">WELCOME</span>
					<br />
					<a href="./signin">
						<button>Sign In</button>
					</a>
					<br />
					<span id="register">
						Not currently a user? <a href="./register">Register here</a>
					</span>
				</div>
			</div>
			Another outer test
		</div>
	);
}

export default SplashView;
