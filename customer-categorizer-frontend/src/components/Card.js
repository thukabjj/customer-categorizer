import './Card.css'

function Card ({name,country,phone,state}) {
    return (
    <div className="card-container">
        <h1>{name}</h1>
        <h2>Country: {country}</h2>
        <h2>Phone: {phone}</h2>
        <h2>State: {state}</h2>
    </div>
    )
}

export default Card

