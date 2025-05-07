<script setup>

</script>

<template>
  <form class="px-4 my-32 mx-auto space-y-6 max-w-3xl border border-b-emerald-600 rounded-4xl">
    <div class="flex space-x-4">
      <div>
        <label for="nombre">Nombre</label>
        <input class="border border-amber-900 py-2 px-4 w-full rounded" type="text" name="nombre" id="nombre">
      </div>
      <div>
        <label for="apellido">apellido</label>
        <input class="border border-amber-900 py-2 px-4 w-full rounded" type="text" name="apellido" id="apellido">
      </div>
    </div>

    <div class="flex space-x-4">
      <div>
        <label for="edad">edad</label>
        <input class="border border-amber-900 py-2 px-4 w-full rounded" type="text" name="edad" id="edad">
      </div>
      
    </div>

    <div class="flex space-x-4">
      <div>
        <label for="altura">altura</label>
        <div class="flex">
          <input class="border border-amber-900 py-2 px-4 w-1/4 rounded-l" type="text" name="altura" id="altura">
          <div class ="flex items-center px-4 bg-amber-900 rounded-r">cm</div>
        </div>
      </div>
      <div>
        <label for="peso">peso</label>
        <div class="flex">
          <input class="border border-amber-900 py-2 px-4 w-1/4 rounded-l" type="text" name="peso" id="peso">
          <div class ="flex items-center px-4 bg-amber-900 rounded-r">kg</div>
        </div>
      </div>
    </div>
    <div class="flex space-x-4">
      <div>
        <label for="experiencia">nivel de experiencia</label>
        <select class="border border-amber-900 py-2 px-4 w-full rounded" name="experiecia" id="experiencia">
          <option value="1">principiante</option>
          <option value="2">intermedio</option>
          <option value="3">avanzado</option>
        </select>
      </div>
    </div>

    <div>
      <button class="rounded-full border-b-indigo-600" type="submit">Enviar</button>
    </div>
    
  </form>
</template>
