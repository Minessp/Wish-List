import {useAtom} from "jotai";
import {sidebarAtom} from "../../atoms/Sidebar.js";
import {SidebarLinks} from "../../data/SidebarLinks.jsx";
import {X} from "lucide-react";

export const SidebarMenu = () => {
    const [isOpen, setIsOpen] = useAtom(sidebarAtom);

    return (
        <aside className={`bg-linear-to-r from-[#3a6bb5] from-80% to-sky-700 rounded-r-lg border-r-2 
        border-sky-200 fixed left-0 top-0 h-screen z-51 duration-300
            ${isOpen ? "w-[192px] md:w-[300px] translate-x-0 opacity-100" :
                "w-0 -translate-x-full opacity-0"}`
        }>
            <div className="w-full flex justify-end items-center pt-4 pr-4 mb-4">
                <button className="cursor-pointer" onClick={() => setIsOpen(false)}>
                    <X strokeWidth={3} color="white" size={35} />
                </button>
            </div>

            <ul className="w-full text-slate-950 font-outfit font-semibold relative flex flex-col items-center gap-10">
                {SidebarLinks.map((link, index) => (
                    <li key={index}>
                        <a href={link.path}>{link.name}</a>
                    </li>
                ))}
            </ul>
        </aside>
    )
}

export default SidebarMenu;