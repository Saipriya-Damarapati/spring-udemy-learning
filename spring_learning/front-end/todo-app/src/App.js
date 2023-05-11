import './App.css';
import LearningComponent from './components/learning-examples/LearningComponent';


// We have the content which is currently loaded in the page in App.js
// All the react components that we will be creating will be the child components of app component
function App() {
  return (
    <div className="App">
      My first REACT web application
      <LearningComponent></LearningComponent>
    </div>
  );
}

export default App;
