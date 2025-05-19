import Logo from "../assets/logo/logo.png";

export const Signup = () => {
    return (
        <div className="w-screen h-screen bg-gradient-to-r from-bg-start to-bg-end to-25% flex flex-col">
            <header className="flex items-center px-6 py-4 fixed w-full z-20 bg-transparent">
                <a href="/">
                    <img className="h-8" src={Logo} alt="Logo" />
                </a>
            </header>

            <div className="flex flex-grow">
                <div className="flex-1 flex items-center justify-center px-4">
                    <h1 className="text-[2.5rem] font-semibold font-outfit text-white"
                        style={{ textShadow: "2px 2px 10px rgba(0,0,0,0.5)" }}
                    >
                        Todos seus desejos em um só lugar
                    </h1>
                </div>

                <div className="w-[30%] relative">
                    <form className="absolute inset-0 bg-white p-10 rounded-l-3xl shadow-2xl flex flex-col justify-center">
                        <div className="w-full flex flex-col items-center">
                            <h2 className="text-4xl font-bold font-outfit mb-8 text-center text-shadow-md">Cadastro</h2>

                            <div className="space-y-6 w-full max-w-80">
                                <input
                                    type="text"
                                    placeholder="Username"
                                    className="w-full p-3 border-b-2 border-t-1 font-semibold font-outfit border-gray-300 rounded-2xl"
                                />
                                <input
                                    type="text"
                                    placeholder="Email"
                                    className="w-full p-3 border-b-2 border-t-1 font-semibold font-outfit border-gray-300 rounded-2xl"
                                />
                                <input
                                    type="password"
                                    placeholder="Senha"
                                    className="w-full p-3 border-b-2 border-t-1 font-semibold font-outfit border-gray-300 rounded-2xl"
                                />

                                <div className="flex justify-center pt-4">
                                    <button
                                        type="submit"
                                        className="px-8 py-2 bg-gradient-to-r font-semibold font-outfit from-submit-button-start to-submit-button-end
                                         text-white rounded-lg hover:opacity-90 hover:-translate-y-1 transition-all shadow-sm shadow-sky-800"
                                    >
                                        Cadastrar
                                    </button>
                                </div>
                            </div>

                            <div className="mt-4 text-center">
                                <span className="text-sm font-semibold">Já tem uma conta? </span>
                                <a href="/login" className="text-sm text-blue-600 hover:underline font-semibold font-outfit">
                                    Entrar
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Signup;