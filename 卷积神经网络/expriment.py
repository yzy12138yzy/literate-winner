import torch

# 创建一个示例张量
x = torch.ones((3))

print(x[torch.tensor([1, 2])])