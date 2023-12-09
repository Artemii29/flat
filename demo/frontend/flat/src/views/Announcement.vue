<template>
  <div>
    <h2>Create Announcement</h2>
    <form @submit="handleSubmit">
      <label>
        Title:
        <input type="text" v-model="title" />
      </label>
      <br />
      <label>
        Description:
        <textarea v-model="description"></textarea>
      </label>
      <br />
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import axios from 'axios';

const title = ref('');
const description = ref('');
const token = ref(localStorage.getItem('token') || ''); // Проверка наличия значения в localStorage
const handleSubmit = async (e: Event) => {
  e.preventDefault();

  // Создание объекта с данными объявления
  const announcementData = {
    title: title.value,
    description: description.value,
  };

  try {
    console.log(token.value);
    // Отправка POST запроса на сервер
    const response = await axios.post('http://localhost:8080/api/v1/announcements/createAnnouncement', announcementData, {
      headers: {
        Authorization: 'Bearer ' + token.value,
      },
    });

    console.log(response.data); // Результат запроса

    // Очистка полей формы
    title.value = '';
    description.value = '';
  } catch (error) {
    console.error(error);
  }
};

</script>
