<script setup lang="ts">
const props = defineProps({
  announcement:{
    type: Object as () => { title: string, description: string },
    required:true
  }
})
</script>

<template>
  <div class="announcements">
<div class="announcement-card">
  <h3>{{ announcement.title }}</h3>
  <p>{{ announcement.description }}</p>
  <button class="look__announcements">Посмотреть</button>
</div>
  </div>
</template>

<style scoped>
.announcement-card {
  border: 1px solid #ccc;
  width: 400px;
  height: 300px;
  margin-bottom: 10px;
  background-color: #f2f2f2;
  border-radius: 20px;
  text-align: center;
  position: relative;
}

.look__announcements{
  border-radius: 20px;
  background-color: aqua;
  color: white;
  position: absolute;
  bottom: 10px;
  left: 50%;
  transform: translateX(-50%);
  text-align: center;
}
h3 {
  font-size: 24px;}

p {
  font-size: 16px;
  margin-top: 50px;
}

</style>