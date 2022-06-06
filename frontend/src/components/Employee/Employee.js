/* eslint-disable jsx-a11y/anchor-is-valid */
import React from "react";
import { useNavigate } from "react-router-dom";

const Employee = ({ Employee, deleteEmployee }) => {
  const navigate = useNavigate();
  const editEmployee = (e, id) => {
    e.preventDefault();
    navigate(`/editEmployee/${id}`);
  };
  return (
    <>
      <tr>
        <td className="text-left px-6 py-4 whitespace-nowrap">
          <div className="text-sm text-black-500">{Employee.firstName}</div>
        </td>
        <td className="text-left px-6 py-4 whitespace-nowrap">
          <div className="text-sm text-black-500">{Employee.lastName}</div>
        </td>
        <td className="text-left px-6 py-4 whitespace-nowrap">
          <div className="text-sm text-black-500">{Employee.email}</div>
        </td>
        <td className="text-right px-6 py-4 whitespace-nowrap font-medium text-sm">
          <a
            onClick={(e, id) => editEmployee(e, Employee.id)}
            className=" text-yellow-500 hover:text-yellow-700 px-4 hover:cursor-pointer"
          >
            Edit
          </a>
          <a
            onClick={(e, id) => deleteEmployee(e, Employee.id)}
            className=" text-red-500 hover:text-red-700 hover:cursor-pointer"
          >
            Delete
          </a>
        </td>
      </tr>
    </>
  );
};

export default Employee;
