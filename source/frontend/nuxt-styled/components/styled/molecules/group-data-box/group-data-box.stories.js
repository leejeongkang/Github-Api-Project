
import GroupDataBox from './group-data-box.vue';

export default {
  title: 'Styled/Molecules/[PCFI] 데이터 박스',
  components: GroupDataBox,
  decorators: [() => ({ template: '<div style="margin: 1em;"><h2 style="margin-bottom: 40px; font-size: 20px; color: #212121;">(예시) 데이터 박스 </h2><story /></div>' })],
};

export const Default = () => ({
  components: { GroupDataBox },
  template: '<GroupDataBox></GroupDataBox>',
  methods: {}
});
