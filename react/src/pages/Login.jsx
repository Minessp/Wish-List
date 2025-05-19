import Logo from "../assets/logo/logo.png";

export const Login = () => {
    return (
        <div className="w-screen min-h-screen bg-gradient-to-r from-bg-start to-bg-end to-25% flex flex-col">
            <header className="flex items-center px-6 py-4 sm:fixed w-full z-20">
                <a href="/">
                    <img className="h-8" src={Logo} alt="Logo" />
                </a>
            </header>

            <div className="flex flex-grow flex-col sm:flex-row pt-20 sm:pt-0">
                <div className="flex-1 flex items-center justify-center px-4 py-10 sm:py-0">
                    <h1
                        className="text-[2.5rem] font-semibold font-outfit text-white text-center"
                        style={{ textShadow: "2px 2px 10px rgba(0,0,0,0.5)" }}
                    >
                        Todos seus desejos em um só lugar
                    </h1>
                </div>

                <div className="w-full sm:w-[40%] lg:w-[30%] relative">
                    <form className="absolute sm:h-full inset-0 bg-white p-10 max-sm:rounded-3xl sm:rounded-l-3xl sm:m-0
                    shadow-2xl flex flex-col justify-center max-lg:relative max-lg:mx-4 max-lg:my-10">
                        <div className="w-full flex flex-col items-center">
                            <h2 className="text-4xl font-bold font-outfit mb-8 text-center text-shadow-md">Login</h2>

                            <div className="space-y-6 w-full max-w-80">
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
                                        Entrar
                                    </button>
                                </div>
                            </div>

                            <div className="mt-6 text-center">
                                <a
                                    href="#"
                                    className="text-sm text-blue-600 hover:underline font-semibold font-outfit text-shadow-sm text-shadow-black/10"
                                >
                                    Esqueceu a senha?
                                </a>
                            </div>

                            <div className="mt-4 text-center">
                                <span className="text-sm font-semibold">Não tem login? </span>
                                <a
                                    href="#"
                                    className="text-sm text-blue-600 hover:underline font-semibold font-outfit"
                                >
                                    Cadastre-se
                                </a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default Login;