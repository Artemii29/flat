import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/registration',
      name: ' Registration',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/views/Registration.vue')
    },
    {
      path:'/authorization',
      name:'Authorization',
      component: () => import('@/views/Authorization.vue')

    },
    {
      path: '/createAnnouncemnt',
      name: 'createAnnouncemnt',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('@/views/Announcement.vue')
    }
  ]
})

export default router