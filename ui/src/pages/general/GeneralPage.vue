<template>
  <navigation-bar :breadcrumbs="breadcrumbs" />

  <div class="pa-3 d-flex flex-column ga-3">
    <navigation-menu :links="links" />
  </div>
</template>

<script setup lang="ts">
import NavigationBar from '@/components/NavigationBar.vue';
import NavigationMenu from '@/components/NavigationMenu.vue';

const breadcrumbs = [
  {
    title: 'General',
    disabled: false,
    href: '/general'
  }
];

const links = [
  {
    title: 'Locations',
    icon: 'mdi-map-marker',
    href: '/general/locations'
  },
  {
    title: 'Customers',
    icon: 'mdi-briefcase-account',
    href: '/general/customers'
  },
  {
    title: 'Suppliers',
    icon: 'mdi-truck',
    href: '/general/suppliers'
  },
  {
    title: 'Articles',
    icon: 'mdi-tag-multiple',
    href: '/general/articles'
  }
];
</script>
