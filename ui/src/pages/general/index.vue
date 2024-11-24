<template>
  <iwy-breadcrumbs :breadcrumbs="breadcrumbs" />

  <div class="pa-3 d-flex flex-column ga-3">
    <iwy-navigation :entries="navigationEntries" />
  </div>
</template>

<script setup lang="ts">
const navigationEntries = [
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

const breadcrumbs = [
  {
    title: 'General',
    disabled: false,
    href: '/general'
  }
];
</script>
