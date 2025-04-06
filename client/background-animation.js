const images = [
    "images/toy.png",
    "images/ring-light.png",
    "images/pots.png",
    "images/projector.png",
    "images/TV.png",
    "images/gamer-chair.png",
    "images/camera.png",
    "images/airpods.png",
    "images/cap.png",
    "images/backpack.png",
    "images/smart-watch.png",
    "images/laptop.png",
    "images/hairbrush.png",
    "images/air-fryer.png",
    "images/ball.png",
    "images/iphone-back-and-front.png",
    "images/iphone-front.png",
    "images/keyboard.png",
    "images/ps5-controller.png",
    "images/ram.png",
    "images/tenis-nike.png",
    "images/tshirt.png",
    "images/xbox-series.png",
    "images/glasses.png"
];


function createFloatingItem() {
    const img = document.createElement("img");
    img.src = images[Math.floor(Math.random() * images.length)];
    img.className = "floating-item";

    const left = Math.random() * 100;
    const delay = Math.random();
    const duration = 8 + Math.random() * 2;

    // Styles
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
