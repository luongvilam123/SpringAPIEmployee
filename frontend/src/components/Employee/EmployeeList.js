/* eslint-disable no-unused-vars */
import React, { useState, useEffect } from "react";
import toast from "react-hot-toast";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../../service/EmployeeService";

import Employee from "./Employee";

const EmployeeList = () => {
  const navigate = useNavigate();

  const [employees, setEmployees] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchdata = async () => {
      setLoading(true);
      try {
        const response = await EmployeeService.getEmployees();
        //console.log(response.data);
        setEmployees(response.data);
      } catch (error) {
        console.log(error);
      }
      setLoading(false);
    };
    fetchdata();
  }, []);

  const deleteEmployee = (e, id) => {
    e.preventDefault();

    EmployeeService.deleteEmployee(id).then((response) => {
      if (employees) {
        setEmployees((prevEmployees) => {
          return prevEmployees.filter((element) => element.id !== id);
        });
      }
    });

    toast.success(`Deleted Employee Has Id ${id} Successfully`);
  };

  return (
    <div className="container mx-auto my-8 ">
      <div className="h-12">
        <button
          className="rounded bg-green-600 text-white px-6 py-2 font-semibold"
          onClick={() => navigate("/addEmployee")}
        >
          Add Employee
        </button>
      </div>

      <div className="flex shadow border-b">
        <table className="min-w-full">
          <thead className="bg-gray-50">
            <tr>
              <th className="text-left font-medium text-blue-700 uppercase tracking-wider py-3 px-6">
                First Name
              </th>
              <th className="text-left font-medium text-blue-700 uppercase tracking-wider py-3 px-6">
                Last Name
              </th>
              <th className="text-left font-medium text-blue-700 uppercase tracking-wider py-3 px-6">
                Email
              </th>
              <th className="text-right font-medium text-blue-700 uppercase tracking-wider py-3 px-6">
                Actions
              </th>
            </tr>
          </thead>
          {!loading && (
            <tbody className="bg-white">
              {employees.map((employee) => (
                <Employee
                  Employee={employee}
                  key={employee.id}
                  deleteEmployee={deleteEmployee}
                />
              ))}
            </tbody>
          )}
        </table>
      </div>
    </div>
  );
};

export default EmployeeList;
