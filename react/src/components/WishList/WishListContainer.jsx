import WishListBox from "./WishListBox.jsx";

export const WishListContainer = () => {
    return (
        <div className="grid grid-cols-[1fr] md:grid-cols-3 gap-8 mt-2 max-w-6xl mx-auto relative z-50">
            <WishListBox />
            <WishListBox />
            <WishListBox />
        </div>
    )
}

export default WishListContainer;