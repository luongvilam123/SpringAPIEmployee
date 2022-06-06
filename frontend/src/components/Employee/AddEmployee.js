/* eslint-disable no-unused-vars */
import * as React from "react";
import { useForm } from "react-hook-form";
import { useState } from "react";
import EmployeeService from "../../service/EmployeeService";
import { useNavigate, useNavigationType } from "react-router-dom";
import toast from "react-hot-toast";

const AddEmployee = () => {
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitted },
  } = useForm();
  const [employee, setEmployee] = useState({
    id: "",
    firstName: "",
    lastName: "",
    email: "",
  });
  
  const navigate = useNavigate();
  const handleChange = (e) => {
    const name = e.target.name;
    const value = e.target.value;

    setEmployee((prevEmployee) => ({
      ...employee,
      [name]: value,
    }));
  };

  const saveEmployee = (employee, e) => {
    e.preventDefault();

    EmployeeService.saveEmployee(employee)
      .then((response) => {
        console.log(response);
        navigate("/employeeList");
        toast.success("Add success !!");
      })
      .catch((error) => {
        console.log(error);
      });
  };
  const reset = (e) => {
    e.preventDefault();
    setEmployee({
      id: "",
      firstName: "",
      lastName: "",
      email: "",
    });
  };

  console.log(errors);

  return (
    <form
      className="flex max-w-2xl shadow border-b mx-auto "
      onSubmit={handleSubmit((employee, e) => saveEmployee(employee, e))}
    >
      <div className="px-8 py-8">
        <div className="font-thin text-2xl tracking-wider text-blue-700">
          <h1>Add New Employee</h1>
        </div>

        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-700 text-sm font-sans">
            First Name
          </label>
          <input
            {...register("firstName", {
              pattern: {
                value: /^[a-zA-Z]+$/,
                message: "Can not contains numbers or special character",
              },
            })}
            onChange={(e) => handleChange(e)}
            name="firstName"
            value={employee.firstName}
            type="text"
            className="shadow border-b h-10 w-96 mt-2 px-2 py-2"
          ></input>
        </div>
        <p className="items-center justify-center h-14 w-full my-4 text-red-600">
          {errors.firstName?.message}
        </p>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-700 text-sm font-sans">
            Last Name
          </label>
          <input
            {...register("lastName", {
              pattern: {
                value: /^[a-zA-Z]+$/,
                message: "Can not contains numbers or special character",
              },
            })}
            onChange={(e) => handleChange(e)}
            name="lastName"
            value={employee.lastName}
            type="text"
            className="shadow border-b h-10 w-96 mt-2 px-2 py-2"
          ></input>
        </div>
        <p className="items-center justify-center h-14 w-full my-4 text-red-600">
          {errors.lastName?.message}
        </p>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="block text-gray-700 text-sm font-sans">Email</label>
          <input
            {...register("email", {
              pattern: {
                value: /^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/i,
                message: "Wrong email address",
              },
            })}
            onChange={(e) => handleChange(e)}
            name="email"
            type="text"
            value={employee.email}
            className="shadow border-b h-10 w-96 mt-2 px-2 py-2"
          ></input>
        </div>
        <p className="items-center justify-center h-14 w-full my-4 text-red-600">
          {errors.email?.message}
        </p>
        <div className="items-center justify-center h-14 w-full my-4 space-x-4">
          <button
            className="rounded text-white bg-green-400 hover:bg-green-700 py-2 px-6"
            // onClick={(e) => saveEmployee(e)}
            type="submit"
          >
            Save
          </button>
          <button
            className="rounded text-white bg-red-400 hover:bg-red-700 py-2 px-6"
            onClick={(e) => reset(e)}
          >
            Clear
          </button>
        </div>
      </div>
    </form>
  );
};

export default AddEmployee;
