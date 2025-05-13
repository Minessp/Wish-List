import {BackgroundImages} from "../data/BackgroundImages.jsx"
import {useEffect, useState} from "react";

export const BackgroundAnimation = () => {
    const [images, setImages] = useState([]);

    useEffect(() => {
        const interval = setInterval(() => {
            const id = crypto.randomUUID()
            const imageSource = BackgroundImages[Math.floor(Math.random() * BackgroundImages.length)];
            const left = Math.random() * 100;
            const delay = Math.random();
            const duration = 8 + Math.random() * 2;

            setImages((prev) => [...prev, {id, imageSource, left, delay, duration}]);

            setTimeout(() => {
                setImages((prev) => prev.filter((item) => item.imageSource !== imageSource));
            }, (delay + duration) * 1000);

            }, 1500);

        return () => clearInterval(interval);
        }, [])

    return (
        <div className="w-full h-screen fixed top-0 left-0 right-0 bg-transparent">
            {images.map((image) => (
                <img
                    className="absolute -bottom-50 animate-float-up"
                    key={image.id}
                    src={image.imageSource}
                    style={{
                        left: `${image.left}%`,
                        animationDelay: `${image.delay}s`,
                        animationDuration: `${image.duration}s`,
                        width: `164px`,
                        height: `164px`,
                    }}
                    alt="imagem-background"
                />
            ))}
        </div>
    )
}

export default BackgroundAnimation;