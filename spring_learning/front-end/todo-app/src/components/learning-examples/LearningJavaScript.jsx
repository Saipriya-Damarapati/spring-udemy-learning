const person = {
    name: 'Ranga',
    address: {
        line1: '123 Baker\'s street',
        city: 'London',
        country: 'UK',
    },
    profiles: ['Twitter', 'LinkedIn', 'Instagram'],
    printProfile: () => {
        console.log(person.profiles[1])
    },
    printAllProfiles: () => {
        person.profiles.map( 
            profile => console.log(profile)
        )
    },
}

function printProfileFromOutsideFunction() {
    console.log(person.profiles[0])
}

export default function LearningJavaScript() {
    return (
        <div>
            <div>Learning Javascript</div>
            <div>{person.name}</div>
            <div>{person.address.line1}</div>
            <div>{person.address.city}</div>
            <div>{person.profiles[0]}</div>
            <div>{printProfileFromOutsideFunction()}</div>
            <div>{person.printProfile()}</div>
            <div>{person.printAllProfiles()}</div>
        </div>
    );
}