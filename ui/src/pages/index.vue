<template>
  <div class="pa-3 d-flex flex-column ga-3">
    <iwy-navigation :entries="navigationEntries" />
  </div>
</template>

<script setup lang="ts">
const navigationEntries = [
  {
    title: 'General',
    icon: 'mdi-math-compass',
    href: '/general'
  },
  {
    title: 'Inventory',
    icon: 'mdi-desk',
    href: '/inventory'
  },
  {
    title: 'Warehouse',
    icon: 'mdi-package-variant-closed',
    href: '/warehouse'
  },
  {
    title: 'Settings',
    icon: 'mdi-cog-outline',
    href: '/settings'
  }
];
</script>
