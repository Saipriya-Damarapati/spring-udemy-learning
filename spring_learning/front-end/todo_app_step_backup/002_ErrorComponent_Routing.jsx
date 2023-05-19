import { useState } from 'react'
import { BrowserRouter, Routes, Route, useNavigate } from 'react-router-dom'
import './TodoApp.css'

export default function TodoApp() {
    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path='/' element={<LoginComponent />}></Route>
                    <Route path='/login' element={<LoginComponent />}></Route>
                    <Route path='/welcome' element={<WelcomeComponent />}></Route>
                    <Route path='*' element={<ErrorComponent />}></Route>
                </Routes>
            </BrowserRouter>
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

    const navigate = useNavigate()

    function handlePasswordChange(event) {
        setPassword(event.target.value)
    }

    function handleSubmit() {
        if(username === 'Ranga1234' && password === 'dummy') {
            displaySuccessDiv(true)
            displayFailureDiv(false)
            navigate("/welcome")
        } else {
            displayFailureDiv(true)
            displaySuccessDiv(false)
        }
    }

    return (
        <div className="login">
            <h1>Time to Login!</h1>
            {showSuccessMessage && <div className='successMessage'>Authenticated Successfully</div>}
            {showFailureMessage && <div className='failureMessage'>Authentication failed, please check your credentials</div>}
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
            <h1>Welcome</h1>
            <div>
                Welcome Component
            </div>
        </div>
    )
}

function ErrorComponent() {
    return (
        <div className="errorComponent">
            <h1>We are working really hard!!</h1>
            <div>
                Apologies for 404. Reach out to our team at ABC-DEF-GHIJ.
            </div>
        </div>
    )
}