import React from 'react'

function Task({task}) {
  return (
    <>
        <div>
          <p>{task.id} {task.title} {task.status}</p>
        </div>
    </>
  )
}

export default Task;
