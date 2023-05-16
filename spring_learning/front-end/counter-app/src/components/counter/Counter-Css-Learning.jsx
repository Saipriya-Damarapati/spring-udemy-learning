import './Counter.css';

export default function Counter() {

    // valid syntax in here is camelCase
    // whereas in actual css file, the two words are separated by hyphen
    // every line in here ends with comma, because this is javascript object
    // whereas in actual css file, every line ends with semi-colon
    // every line in here has attribute value enclosed in double quotes, because this is javascript object
    // whereas in actual css file, attribute values are not enclosed in double quotes
    const buttonStyle = {
        fontSize: "40px",
        backgroundColor: "#00a5ab",
        margin: "10px",
        padding: "15px",
        borderRadius: "30px"
    }

    function incrementCounter() {
        console.log("increment button clicked")
    }

    // css can be defined inline with style attribute
    return (
        <div>
            <div className="Counter">Counter</div>
            <span className="count">0</span>
            <div>
                <button className="counterButton" onClick={incrementCounter} style={{fontSize: "40px"}}>Inline Styling</button>
            </div>

            <div>
                <button className="counterButton" onClick={incrementCounter} style={buttonStyle}>Inline Styling with javascript constant object</button>
            </div>

            <div>
                <button className="counterButtonCss" onClick={incrementCounter}>ClassName Styling from css file</button>
            </div>
        </div>
    );
}