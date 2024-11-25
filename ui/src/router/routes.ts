export default [
  {
    path: '/',
    component: () => import('@/pages/HomePage.vue')
  },
  {
    path: '/general',
    component: () => import('@/pages/general/GeneralPage.vue')
  },
  {
    path: '/general/locations',
    component: () => import('@/pages/general/LocationsPage.vue')
  }
];
