<?php

namespace App\Entity;

use App\Repository\MessagerieRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

#[ORM\Entity(repositoryClass: MessagerieRepository::class)]
class Messagerie
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column(length: 255)]
    #[Assert\NotBlank(message: "ecrire le nom de Récepteur")]
    private ?string $nomrex = null;

    #[ORM\Column(length: 255)]
    #[Assert\NotBlank(message: "ecrire le nom d'Expéditeur")]
    private ?string $nomex = null;

    #[ORM\Column(type: "text", length: 255)]
    #[Assert\NotBlank(message: "ecrire le message")]
    private ?string $msg = null;

    #[ORM\Column]
    private ?bool $vu = null;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomrex(): ?string
    {
        return $this->nomrex;
    }

    public function setNomrex(string $nomrex): self
    {
        $this->nomrex = $nomrex;

        return $this;
    }

    public function getNomex(): ?string
    {
        return $this->nomex;
    }

    public function setNomex(string $nomex): self
    {
        $this->nomex = $nomex;

        return $this;
    }

    public function getMsg(): ?string
    {
        return $this->msg;
    }

    public function setMsg(string $msg): self
    {
        $this->msg = $msg;

        return $this;
    }

    public function isVu(): ?bool
    {
        return $this->vu;
    }

    public function setVu(bool $vu): self
    {
        $this->vu = $vu;

        return $this;
    }
}
