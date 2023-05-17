import './TodoApp.css'

export default function TodoApp() {
    return (
        <div>
            <LoginComponent />
            <WelcomeComponent />
        </div>
    )
}

function LoginComponent() {
    return (
        <div className="login">
            <div className="loginform">
                <div>
                    <label className="labelCss">User Name</label>
                    <input type="text" name="username"/>
                </div>

                <div>
                    <label className="labelCss">Password</label>
                    <input type="password" name="password"/>
                </div>

                <div>
                    <button className="submitButton">Login</button>
                </div>
            </div>
        </div>
    )
}

function WelcomeComponent() {
    return (
        <div className="welcome">
            Welcome Component
        </div>
    )
}