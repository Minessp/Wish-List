import {BackgroundImages} from "../data/BackgroundImages.jsx"
import {useRef} from "react";

export const BackgroundAnimation = () => {
    const imgRef = useRef();

    const randomizeProperties = () => {
        const left = Math.random() * 100;
        const delay = Math.random();
        const duration = 8 + Math.random() * 2;
    }

    

    return (
        <div className="w-full h-screen fixed top-0 left-0 right-0 bg-transparent">
            <img src={BackgroundImages[Math.floor(Math.random() * BackgroundImages.length)]} ref={imgRef}
                 alt="background-image"/>
        </div>
    )
}

export default BackgroundAnimation;