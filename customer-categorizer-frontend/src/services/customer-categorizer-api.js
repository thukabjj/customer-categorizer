import axios from "axios";

async function getCustomersCategorized() {
    const result = await axios.get(process.env.REACT_APP_CUSTOMER_CATEGORIZER_URL)
    if(result.status !== 200) {
        return null
    }
    return result.data
}

export default getCustomersCategorized;