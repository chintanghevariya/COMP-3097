const Button = function({btnText, action}){
    return(
        <button className="btn" onClick={action}>
            {btnText}
        </button>
    )
}
export { Button };