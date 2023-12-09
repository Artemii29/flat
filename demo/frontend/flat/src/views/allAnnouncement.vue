

<template>
<div>
  <div v-for="announcement in announcements">
    {{announcement.title}}
    {{announcement.description}}
  </div>
</div>
</template>
<script setup lang="ts">
import {onMounted, ref} from "vue";
import axios from "axios";
const announcements = ref<{ title: string, description: string }[]>([]);
const token = ref(localStorage.getItem('token') || ''); // Проверка наличия значения в localStorage

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:8080/api/v1/announcements/getAnnouncement', {
          headers: {
            Authorization: 'Bearer ' + token.value
          }
        }
    )
    announcements.value = response.data
  }
catch (error){
  console.log(error)
}
  }
)
</script>
<style scoped>

</style>