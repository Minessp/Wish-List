import {Plus} from "lucide-react";

export const WishListBox = () => {
    return (
        <button className="flex flex-col justify-center items-center bg-white/5 p-10
        rounded-xl cursor-pointer min-h-[200px] border-2 border-dashed border-white/30 h-70">
            <Plus color="white" strokeWidth={2.5} size={48}/>
            <p className="text-white font-outfit">Criar nova lista</p>
        </button>
    )
}

export default WishListBox;