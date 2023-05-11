import FirstComponent from './FirstComponent';
import SecondComponent from './SecondComponent';
import ThirdComponent from './ThirdComponent';
import FourthComponent from './FourthComponent';
// this would print FirstComponent because it is not having braces, and gets data from defaut function
import TenthComponent from './FirstComponent';
// having braces indicate that they are not from default component
import {FifthComponent} from './FirstComponent'; 
import LearningJavaScript from './LearningJavaScript';

export default function LearningComponent() {
    return (
        <div>
            <FirstComponent></FirstComponent>
            <SecondComponent></SecondComponent>
            <ThirdComponent></ThirdComponent>
            <FourthComponent></FourthComponent>
            <TenthComponent></TenthComponent>
            <FifthComponent></FifthComponent>
            <LearningJavaScript />
        </div>
    );
}