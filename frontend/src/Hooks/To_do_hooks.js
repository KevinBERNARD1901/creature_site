import { useEffect, useState } from "react";

const base_url_api = 'http://localhost:8080';

const getTasks = function () {
    const [tasks, setTasks] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const getTasks_ = async () => {
            try {
                const response = await fetch(`${base_url_api}/tasks`);
                const data = await response.json();
                setTasks(data);
            } catch(err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        getTasks_();
    }, []);
}

const getTasksById = function (id) {
    const [task, setTask] = useState([]);
    const [loading, setLoading] = useState(true);
    const [erroe, setError] = useState(null);

    useEffect(() => {
        const getTasksById_ = async () => {
            try {
                const response = await fetch(`${base_url_api}/tasks/${id}`);
                const data = await response.json();
                setTask(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        getTasksById_();
    }, [id]);
}

export default getTasks;

// = async function() {
//     try {
//         const response = await fetch(`${base_url_api}/tasks`)
//         const data = await response.json();
//         setTasks(data);
//     } catch(err) {
//         console.log(err)
//     }
// }