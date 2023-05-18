import { useState } from 'react'
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

    const [username, setUsername] = useState('Ranga')

    function handleUsernameChange(event) {
        setUsername(event.target.value)
    }

    const [password, setPassword] = useState('')

    const [showSuccessMessage, displaySuccessDiv] = useState(false)
    const [showFailureMessage, displayFailureDiv] = useState(false)

    function handlePasswordChange(event) {
        setPassword(event.target.value)
    }

    function handleSubmit() {
        if(username === 'Ranga1234' && password === 'dummy') {
            displaySuccessDiv(true)
            displayFailureDiv(false)
        } else {
            displayFailureDiv(true)
            displaySuccessDiv(false)
        }
    }

    function SuccessMessageComponent() {
        if(showSuccessMessage) {
            return <div className='successMessage'>Authenticated Successfully</div>
        } else {
            return null
        }
    }
    
    function FailureMessageComponent() {
        if(showFailureMessage) {
            return <div className='failureMessage'>Authentication failed, please check your credentials</div>
        } else {
            return null
        }
    }


    return (
        <div className="login">
            <SuccessMessageComponent />
            <FailureMessageComponent />
            <div className="loginform">
                <div>
                    <label>User Name</label>
                    <input type="text" name="username" value={username} onChange={handleUsernameChange}/>
                </div>

                <div>
                    <label>Password</label>
                    <input type="password" name="password" value={password} onChange={handlePasswordChange}/>
                </div>

                <div>
                    <button type="button" name="login" onClick={handleSubmit}>Login</button>
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