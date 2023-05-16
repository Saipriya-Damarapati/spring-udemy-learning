import './App.css';
import Counter from './components/counter-exercise/Counter';

function App() {
  return (
    <div className="App">
      <Counter />
    </div>
  );
}

export default App;

// function PlayingWithProps(properties) {
//   console.log(properties)
//   console.log(properties.property1)
//   console.log(properties.property2)
//   return (
//     <div>
//       props
//     </div>
//   )
// }

// modern JS approach - deconstruction of JS object
// function PlayingWithProps({property1, property2}) {
//   console.log(property1)
//   console.log(property2)
//   return (
//     <div>
//       props
//     </div>
//   )
// }