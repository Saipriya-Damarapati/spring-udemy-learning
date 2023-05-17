import './App.css';
import TodoApp from './components/todo/TodoApp';


// We have the content which is currently loaded in the page in App.js
// All the react components that we will be creating will be the child components of app component
function App() {
  return (
    <div className="App">
      <TodoApp></TodoApp>
    </div>
  );
}

export default App;
