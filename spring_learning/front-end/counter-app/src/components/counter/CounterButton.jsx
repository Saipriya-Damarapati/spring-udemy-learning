import { PropTypes } from 'prop-types'

export default function CounterButton({by, incrementMethod, decrementMethod}) {

    // state is an array of type [0, f]
    // useState takes in initial value as parameter and returns the current state and the function to update state
    // const state = useState(0); --> this line can be written as below after deconstructing
    //const [count, setCount] = useState(0); // now count contains current state and setCount is the update function

    function incrementCounter() {
        //state[1](state[0] + 1) --> this can be written as below
        //setCount(count + by)
        incrementMethod(by);
    }

    function decrementCounter() {
        //setCount(count - by)
        decrementMethod(by);
    }

    return (
        <div>
            <div>
                <button className="counterButtonCss" onClick={incrementCounter}>+{by}</button>
                <button className="counterButtonCss" onClick={decrementCounter}>-{by}</button>
            </div>
        </div>
    );
}

// in-order to restrict the data-type of property by
CounterButton.propTypes = {
    by: PropTypes.number
}

// to set the default value to the props
CounterButton.defaultProps = {
    by: 1
}