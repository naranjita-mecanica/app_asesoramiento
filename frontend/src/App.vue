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
  <header class="navbar-header">
      <img src="../src/img/iconButton.png" alt="Perfil" class="profile-img" />
    <h2>PERFIL DE USUARIO</h2>
  </header>
  <div class="center-container">
    <div class="container-bg">
      <div class="user-profile-form">
        <form >
          <div class="form-group">
            <label>NOMBRE COMPLETO:</label>
            <input 
              type="text" 
              v-model="form.nombre" 
            />
          </div>
          <div class="form-group">
            <label>SEXO:</label>
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
            <div class="custom-number-input">
              <input
                type="number"
                v-model="form.altura"
                min="0"
              />
              <img
                src="../src/img/polygonUp.png"
                alt="Subir"
                class="arrow arrow-up"
                @click="form.altura = Number(form.altura) + 1"
              />
              <img
                src="../src/img/polygonDown.png"
                alt="Bajar"
                class="arrow arrow-down"
                @click="form.altura = Math.max(0, Number(form.altura) - 1)"
              />
              <span class="unidad">cm</span>
            </div>
          </div>
          <div class="form-group">
            <label>PESO:</label>
            <div class="custom-number-input">
              <input 
                type="number" 
                v-model="form.peso" 
                min="0"
              />
              <img
                src="../src/img/polygonUp.png"
                alt="Subir"
                class="arrow arrow-up"
                @click="form.peso = Number(form.peso) + 1"
              />
              <img
                src="../src/img/polygonDown.png"
                alt="Bajar"
                class="arrow arrow-down"
                @click="form.peso = Math.max(0, Number(form.peso) - 1)"
              />
              <span class="unidad">kg</span>
            </div>
          </div>
          <div class="form-group">
            <label>EDAD:</label>
            <div class="slider-group">
              <input 
                type="range" 
                v-model="form.edad" 
                min="12" 
                max="100"
                class="edad-slider"
              />
              <span class="edad-valor">{{ form.edad }}</span>
              <span class="unidad">años</span>
            </div>
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
    </div>
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Orbitron:wght@400;700&display=swap');

.navbar-header {
  width: 100%;
  height: 72px;
  background: #2C2C2C;
  display: flex;
  align-items: center;
  padding: 0 32px;
  box-sizing: border-box;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 100;
  gap: 16px;
  font-family: 'Orbitron', Arial, sans-serif;
}

.profile-img {
  width: 36px;
  height: 36px;
  object-fit: cover;
  border-radius: 50%;
  display: block;
}

.navbar-header h2 {
  color: #fff;
  margin: 0;
  font-size: 1.5rem;
  font-weight: bold;
  font-family: 'Orbitron', Arial, sans-serif;
}

.center-container {
  min-height: 100vh;
  min-width: 90vw;
  display: flex;
  align-items: center;
  justify-content: center;
  background: transparent;
  padding-top: 72px;
  box-sizing: border-box;
  font-family: 'Orbitron', Arial, sans-serif;
}

.container-bg {
  background: #261F1D9E;
  border-radius: 114px;
  padding: 80px 40px 80px 40px;
  box-shadow: 0 4px 24px rgba(0,0,0,0.08);
  display: flex;
  justify-content: center;
  align-items: flex-start;
  font-family: 'Orbitron', Arial, sans-serif;
  width: 800px;
  min-width: 350px;
  max-width: 95vw;
  min-height: 900px;
}

.user-profile-form {
  max-width: 500px;
  width: 100%;
  margin: 0 auto;
  padding: 0 0 24px 0;
  font-family: 'Orbitron', Arial, sans-serif;
  color: #fff;
  text-align: left;
  align-items: flex-start;
}

.form-group {
  margin-bottom: 24px;
  font-family: 'Orbitron', Arial, sans-serif;
  display: flex;
  align-items: center;
  border-bottom: 1px solid #FFFFFF;
  padding-bottom: 12px;
}

.form-group:last-child {
  border-bottom: none;
  margin-bottom: 0;
  padding-bottom: 0;
}

.form-group label {
  display: block;
  margin-bottom: 0;
  font-weight: bold;
  color: #fff;
  font-family: 'Orbitron', Arial, sans-serif;
  min-width: 170px;
}

.form-group input[type="text"],
.form-group input[type="number"] {
  width: 100%;
  padding: 8px;
  border: none;
  border-radius: 100px;
  font-family: 'Orbitron', Arial, sans-serif;
  background: #35353596;
  color: #fff;
  outline: none;
  box-shadow: 0 2px 8px rgba(0,0,0,0.25);
}

.radio-group {
  display: flex;
  font-family: 'Orbitron', Arial, sans-serif;
}

.radio-group label {
  display: flex;
  align-items: center;
  gap: 5px;
  font-weight: normal;
  color: #fff;
  font-family: 'Orbitron', Arial, sans-serif;
}

.radio-group input[type="radio"] {
  accent-color: #FF5B29;
  background: #1E1E1E;
  border: 2px solid #FF5B29;
  width: 18px;
  height: 18px;
  margin-right: 6px;
  appearance: none;
  border-radius: 50%;
  outline: none;
  transition: background 0.2s, border 0.2s;
  position: relative;
}

.radio-group input[type="radio"]:checked {
  background: #FF5B29;
  border: 2px solid #FF5B29;
}

.radio-group input[type="radio"]::before {
  content: '';
  display: block;
  width: 6px;
  margin: 5px auto;
  border-radius: 50%;
  background: transparent;
  transition: background 0.2s;
}

.radio-group input[type="radio"]:checked::before {
  background: #FF5B29;
}

.form-actions {
  display: flex;
  justify-content: space-between;
  margin-top: 20px;
  font-family: 'Orbitron', Arial, sans-serif;
}

.form-actions button {
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-family: 'Orbitron', Arial, sans-serif;
}

.update-btn {
  background-color: #827D7D;
  color: white;
}

.save-btn {
  background-color: #FF5B29;
  color: white;
}

.form-group input[type="number"] {
  accent-color: #D9D9D9;
}

.form-group input[type="number"]::-webkit-inner-spin-button,
.form-group input[type="number"]::-webkit-outer-spin-button {
  -webkit-appearance: none;
  appearance: none;
  margin: 0;
}

.custom-number-input {
  display: flex;
  align-items: center;
  gap: 8px;
}

.custom-number-input input[type="number"] {
  width: 80px;
  margin-right: 4px;
}

.arrow {
  width: 20px;
  height: 20px;
  cursor: pointer;
  margin: 0 2px;
}

.unidad {
  margin-left: 4px;
  font-weight: bold;
  color: #fff;
}

.slider-group {
  display: flex;
  align-items: center;
  gap: 8px;
  font-family: 'Orbitron', Arial, sans-serif;
}

.edad-slider {
  -webkit-appearance: none;
  appearance: none;
  width: 180px;
  height: 4px;
  border-radius: 2px;
  background: #444444;
  outline: none;
  cursor: pointer;
}

.edad-slider::-webkit-slider-thumb {
  -webkit-appearance: none;
  appearance: none;
  width: 18px;
  height: 18px;
  border-radius: 50%;
  background: #FF5B29;
  border: none;
  cursor: pointer;
  box-shadow: 0 0 2px #222;
}

.edad-slider::-moz-range-thumb {
  width: 18px;
  height: 18px;
  border-radius: 50%;
  background: #FF5B29;
  border: none;
  cursor: pointer;
  box-shadow: 0 0 2px #222;
}

.edad-slider::-moz-range-track {
  background: #444444;
  height: 4px;
  border-radius: 2px;
}

.edad-slider::-ms-fill-lower,
.edad-slider::-ms-fill-upper {
  background: #444444;
  border-radius: 2px;
}

.edad-slider:focus {
  outline: none;
}

.edad-slider::-ms-thumb {
  width: 18px;
  height: 18px;
  border-radius: 50%;
  background: #FF5B29;
  border: none;
  cursor: pointer;
  box-shadow: 0 0 2px #222;
}

.edad-valor {
  font-weight: bold;
  color: #fff;
  min-width: 40px;
  text-align: center;
}

html, body {
  background: #2C2C2C !important;
}
</style>

<style>
html, body {
  background: #2C2C2C !important;
}
</style>