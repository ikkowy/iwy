<template>
  <div class="pa-3 d-flex flex-column ga-3">
    <iwy-breadcrumbs :breadcrumbs="breadcrumbs" />
    <iwy-navigation :entries="navigationEntries" />
  </div>
</template>

<script setup lang="ts">
const navigationEntries = [
  {
    title: 'Locations',
    icon: 'mdi-map-marker',
    href: '/general/locations'
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
