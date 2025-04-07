const images = [
    "images/background-images/toy.png",
    "images/background-images/ring-light.png",
    "images/background-images/pots.png",
    "images/background-images/projector.png",
    "images/background-images/TV.png",
    "images/background-images/gamer-chair.png",
    "images/background-images/camera.png",
    "images/background-images/airpods.png",
    "images/background-images/cap.png",
    "images/background-images/backpack.png",
    "images/background-images/smart-watch.png",
    "images/background-images/laptop.png",
    "images/background-images/hairbrush.png",
    "images/background-images/air-fryer.png",
    "images/background-images/ball.png",
    "images/background-images/iphone-back-and-front.png",
    "images/background-images/iphone-front.png",
    "images/background-images/keyboard.png",
    "images/background-images/ps5-controller.png",
    "images/background-images/ram.png",
    "images/background-images/tenis-nike.png",
    "images/background-images/tshirt.png",
    "images/background-images/xbox-series.png",
    "images/background-images/glasses.png"
];

function createFloatingItem() {
    const img = document.createElement("img");
    img.src = images[Math.floor(Math.random() * images.length)];
    img.className = "floating-item";

    const left = Math.random() * 100;
    const delay = Math.random();
    const duration = 8 + Math.random() * 2;

    img.style.left = `${left}%`;
    img.style.animationDelay = `${delay}s`;
    img.style.animationDuration = `${duration}s`;
    img.style.width = `80px`;
    img.style.height = `80px`;

    document.querySelector(".background-animation").appendChild(img);

    setTimeout(() => {
    img.remove();
    }, (delay + duration) * 1000);
}

setInterval(createFloatingItem, 1000);
