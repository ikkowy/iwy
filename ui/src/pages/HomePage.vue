<template>
  <navigation-bar :breadcrumbs="[]" />

  <div class="pa-3 d-flex flex-column ga-3">
    <navigation-menu :links="links" />
  </div>
</template>

<script setup lang="ts">
import NavigationBar from '@/components/NavigationBar.vue';
import NavigationMenu from '@/components/NavigationMenu.vue';

const links = [
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
    icon: 'mdi-cog',
    href: '/settings'
  }
];
</script>
