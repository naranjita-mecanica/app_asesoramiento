
<script setup lang="ts">
  import { ref } from "vue";

  const form = ref(
    {
      nombre : '',
      sexo : [],
      edad : '',
      peso : '',
      altura : '',
      experiencia : []
    });
  

  const emit = defineEmits(['handleSubmit']);

  const handleSubmit = async function(event) 
  {
    event.preventDefault();
    
    try
    {
      const response = await fetch("http://localhost:8081/api/usuario/agrergar",{
        method : "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(form.value)
      });
      const data =  await response.json();
      if (response.ok) {
        alert("Usuario agregado con exito");
        location.reload();
        
      } else {
        // Mostrar mensaje de error
        alert(data.message || "Error en al agregar usuario");
      }
    } catch (error) {
      console.error("Error al realizar la solicitud:", error);
      alert(error);
    }
  }
  
</script>

<template>
  <div class="user-profile-form">
    <h2>PERFIL DE USUARIO</h2>
    
    <form >
      <div class="form-group">
        <label>NOMBRE COMPLETO:</label>
        <input 
          type="text" 
          v-model="form.nombre" 
          placeholder="__"
        />
      </div>
      
      <div class="form-group">
        <label>sexo:</label>
        <div class="radio-group">
          <label>
            <input 
              type="radio" 
              v-model="form.sexo" 
              value="M" 
            />
            MASCULINO
          </label>
          <label>
            <input 
              type="radio" 
              v-model="form.sexo" 
              value="F" 
            />
            FEMENINA
          </label>
        </div>
      </div>
      
      <div class="form-group">
        <label>ALTURA:</label>
        <input 
          type="text" 
          v-model="form.altura" 
          placeholder="__"
        />
      </div>
      
      <div class="form-group">
        <label>PESO:</label>
        <input 
          type="text" 
          v-model="form.peso" 
          placeholder="__"
        />
      </div>
      
      <div class="form-group">
        <label>EDAD:</label>
        <input 
          type="text" 
          v-model="form.edad" 
          placeholder="__"
        />
      </div>
      
      <div class="form-group">
        <label>EXPERIENCIA FISICA:</label>
        <div class="radio-group">
          <label>
            <input 
              type="radio" 
              v-model="form.experiencia" 
              value="1" 
            />
            PRINCIPIANTE
          </label>
          <label>
            <input 
              type="radio" 
              v-model="form.experiencia" 
              value="2" 
            />
            INTERMEDIO
          </label>
          <label>
            <input 
              type="radio" 
              v-model="form.experiencia" 
              value="3" 
            />
            AVANZADO
          </label>
        </div>
      </div>
      
      <div class="form-actions">
        <button type="button" class="update-btn" @click="handleUpdate">ACTUALIZAR</button>
        <button type="submit" class="save-btn" @click="handleSubmit">GUARDAR</button>
      </div>
    </form>
  </div>
</template>



<style scoped>
.user-profile-form {
  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial, sans-serif;
}

.user-profile-form h2 {
  text-align: center;
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 15px;
}

.form-group label {
  display: block;
  margin-bottom: 5px;
  font-peso: bold;
}

.form-group input[type="text"] {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

.radio-group {
  display: flex;
  gap: 15px;
}

.radio-group label {
  display: flex;
  align-items: center;
  gap: 5px;
  font-peso: normal;
}

.form-actions {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
}

.form-actions button {
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.update-btn {
  background-color: #f0f0f0;
}

.save-btn {
  background-color: #4CAF50;
  color: white;
}
</style>