import "./Home.css";
import { useEffect, useState } from "react";

import { DropdownButton, Dropdown, Button } from "react-bootstrap";

import Card from "../components/Card";

import getCustomersCategorized from "../services/customer-categorizer-api";

const mapState = {VALID: "Valid" ,NOT_VALID:"Not Valid"};
function Home() {

  const [customers, setCustomers] = useState({
    filters: { country: null, state: null },
    data: [],
  });

  const [countries, setCountries] = useState([]);
  const [states, setStates] = useState([]);

  useEffect(() => {
    getCustomersCategorized().then((data) => {

    const customData = data.map((customer) => {
        return {
            ...customer,
            state: mapState[customer.state]
        }
    })
      setCustomers((previousState) => {
        return { ...previousState, data: customData };
      });

      setCountries(
        Array.from(new Set(customData.map((customer) => customer.country)))
      );

      setStates(Array.from(new Set(customData.map((customer) => customer.state))));
    });
  }, []);

  function handlerCleanFilters(e) {
    setCustomers((previousState) => {
      return { ...previousState, filters: { country: null, state: null } };
    });
  }

  function handlerChangeState(e) {
    setCustomers((previousState) => {
      return {
        ...previousState,
        filters: { ...previousState.filters, state: e },
      };
    });
  }
  function handlerChangeCountry(e) {
    setCustomers((previousState) => {
      return {
        ...previousState,
        filters: { ...previousState.filters, country: e },
      };
    });
  }

  return (
    <div className="home-container">
      <header>
        <h1>Customers</h1>
        <div className="home-container-filter">
          <DropdownButton
            id="dropdown-variants-secondary"
            onSelect={handlerChangeCountry}
            variant="secondary"
            className="custom-font"
            title={customers.filters.country || "Countries"}
          >
            {countries.map((country) => {
              return (
                <Dropdown.Item eventKey={country} key={country}>
                  {country}
                </Dropdown.Item>
              );
            })}
          </DropdownButton>
          <DropdownButton
            id="dropdown-variants-secondary"
            onSelect={handlerChangeState}
            variant="secondary"
            className="custom-font"
            title={customers.filters.state || "State"}
          >
            {states.map((state) => {
              return (
                <Dropdown.Item eventKey={state} key={state}>
                  {state}
                </Dropdown.Item>
              );
            })}
          </DropdownButton>
          <Button variant="primary"  className="custom-font" onClick={handlerCleanFilters}>
            Clean Filters
          </Button>
        </div>
      </header>
      <ul className="home-container-list">
        {customers.filters.country === null &&
          customers.filters.state === null &&
          customers.data.map((customer) => {
            return (
              <li key={customer.id}>
                <Card {...customer} />
              </li>
            );
          })}

          {customers.filters.country !== null &&
          customers.filters.state === null &&
          customers.data
          .filter(customer => customer.country === customers.filters.country)
          .map((customer) => {
            return (
              <li key={customer.id}>
                <Card {...customer} />
              </li>
            );
          })}

          {customers.filters.country === null &&
          customers.filters.state !== null &&
          customers.data
          .filter(customer => customer.state === customers.filters.state)
          .map((customer) => {
            return (
              <li key={customer.id}>
                <Card {...customer} />
              </li>
            );
          })}

          {customers.filters.country !== null &&
          customers.filters.state !== null &&
          customers.data
          .filter(customer => customer.state === customers.filters.state && customer.country === customers.filters.country)
          .map((customer) => {
            return (
              <li key={customer.id}>
                <Card {...customer} />
              </li>
            );
          })}

      </ul>
    </div>
  );
}

export default Home;
